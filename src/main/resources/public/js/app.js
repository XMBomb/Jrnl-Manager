var JrnlManager = function($) {
	$.get('/entries/random', function(data) {
		var dateTime = new Date(data.date);

		var weekDays = ['Sonntag','Montag','Dienstag','Mittwoch','Donnerstag','Freitag','Samstag'];

		var locale = 'de-CH';
		var dateStr = dateTime.toLocaleDateString(locale);
		var timeStr = dateTime.toLocaleTimeString(locale);
		var weekDayStr = weekDays[dateTime.getDay()];
		$('#random-entry .entry-datetime').html(weekDayStr + " " + dateStr + " " + timeStr);
		$('#random-entry .entry-content').html(data.title + data.body);
	});

	$.get('/tags', function(data) {
		data.sort(function(a,b){
			a = a.numUses;
			b = b.numUses;
			if (a > b) {
				return -1;
			}
			if (a < b) {
				return 1;
			}
			return 0;
		});
		var allTagsChartCanvas = $('#all-tags-chart');
		tagNames = new Array();
		tagValues = new Array();

		data.forEach(function(el){tagNames.push(el.name);});
		data.forEach(function(el){tagValues.push(el.numUses);});

		var color = new Color();
		colors = data.map(function(index, elem) {
			return color.getRandomColor();
		})

		var data = {
			labels: tagNames,
			datasets: [{
				backgroundColor: colors,
				data: tagValues
			}]
		};

		var options = {
			scales: {
				xAxes: [{
					categoryPercentage: 1.0,
					barPercentage: 1.0
				}]
			}
		};

		this.allTagsChart = new Chart(allTagsChartCanvas, {
			type: 'bar',
			data: data,
			options: options
		});
	});
}(jQuery);

var Color = function(){};
Color.prototype.getRandomColor = function(){
	var letters = '0123456789ABCDEF';
	var color = '#';
	for (var i = 0; i < 6; i++ ) {
		color += letters[Math.floor(Math.random() * 16)];
	}
	return color;
};