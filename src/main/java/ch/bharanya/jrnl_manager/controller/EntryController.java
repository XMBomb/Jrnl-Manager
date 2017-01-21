package ch.bharanya.jrnl_manager.controller;

import ch.bharanya.jrnl_manager.controller.message.ErrorMessage;
import ch.bharanya.jrnl_manager.controller.util.Http;
import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import ch.bharanya.jrnl_manager.service.JrnlService;
import ch.bharanya.jrnl_manager.controller.util.JsonTransformer;
import spark.Spark;

import java.util.List;
import java.util.Optional;

public class EntryController implements IController {

    @Override
    public void setup() {
        Spark.get("/entries", (request, response) -> JrnlService.getInstance().getJrnlEntries(), new JsonTransformer());

        Spark.get("/entries/date/:datetime", (request, response) -> {
            String dateTime = request.params(":datetime");
            Optional<JrnlEntry> jrnlEntry = JrnlService.getInstance().findJrnlEntryWithDateTime(dateTime);

            if (jrnlEntry.isPresent()) return jrnlEntry.get();

            response.status(Http.NOT_FOUND);
            return new ErrorMessage("Could not find an entry with datetime %s", dateTime);
        }, new JsonTransformer());

        Spark.get("/entries/search/:searchText", (request, response) -> {
            List<JrnlEntry> entries = JrnlService.getInstance().findJrnlEntries(request.params(":searchText"));
            if (entries.size() == 0) response.status(Http.NOT_FOUND);
            return entries;
        }, new JsonTransformer());

        Spark.get("/entries/random", (request, response) -> JrnlService.getInstance().findRandomEntry(), new JsonTransformer());
    }
}