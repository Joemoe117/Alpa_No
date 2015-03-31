$(function() {
  $('#j_idt23\\:checkInDate').datepicker(
    {
		dateFormat: 'yy-mm-dd',
		minDate: new Date(2000, 1 - 1, 1),
		firstDay :1,
		monthNames: ['Janvier','F�vrier','Mars','Avril','Mai','Juin','Juillet','Ao�t','Septembre','Octobre','Novembre','D�cembre'],
		monthNamesShort: ['Jan','F�v','Mar','Avr','Mai','Jun','Jul','Ao�','Sep','Oct','Nov','D�c'],
		dayNames: ['Dimanche','Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'],
		dayNamesShort: ['Dim','Lun','Mar','Mer','Jeu','Ven','Sam'],
		dayNamesMin: ['Di','Lu','Ma','Me','Je','Ve','Sa']			
    });
});

$(function() {
	  $('#j_idt23\\:checkOutDate').datepicker(
	    {
			dateFormat: 'yy-mm-dd',
			minDate: new Date(2000, 1 - 1, 1),
			firstDay :1,
			monthNames: ['Janvier','F�vrier','Mars','Avril','Mai','Juin','Juillet','Ao�t','Septembre','Octobre','Novembre','D�cembre'],
			monthNamesShort: ['Jan','F�v','Mar','Avr','Mai','Jun','Jul','Ao�','Sep','Oct','Nov','D�c'],
			dayNames: ['Dimanche','Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'],
			dayNamesShort: ['Dim','Lun','Mar','Mer','Jeu','Ven','Sam'],
			dayNamesMin: ['Di','Lu','Ma','Me','Je','Ve','Sa']			
	    });
	});