
var weddingStart = new Date('2011/11/12 14:30:00');
var weddingDurationHours = 7;

$('document').ready(function(){ paintTime(); });

function paintTime() {
	// calculate difference between now and the start time
	var timeTilStart = weddingStart - new Date();
	var weddingDuration = weddingDurationHours*60*60*1000;
	var message;
	if (timeTilStart > 0) {
		message = getTimeString(timeTilStart) + " until the wedding!";
	}
	else {
	    timeSinceStart = Math.abs(timeTilStart);
	    if (timeSinceStart < weddingDuration) {
	    	message = "The wedding is happening right now!";
	    }
	    else {
	    	message = "We've been married for " + getTimeString(timeSinceStart) + "!";
	    }
	}
	$('.countdown')[0].innerHTML = message;
	// queue update in slightly less than 1 second
	setTimeout("paintTime()", 995);
}

function getTimeString(timeSegment) {
	// calculate remaining days
	var days = Math.floor( timeSegment/( 24*60*60*1000 ) );
	// calculate remaining hours
	var hrs = Math.floor( ( timeSegment/( 60*60*1000 ) )%24 );
	// calculate remaining minutes
	var mins = Math.floor( ( timeSegment/( 60*1000) )%60 );
	// calculate remaining seconds
	var secs = Math.floor( ( timeSegment/( 1000 ) )%60 );
	// compose countdown message
	var cd = days + ' days, ' +
	  hrs + ' hours, ' +
	  mins + ' minutes, and ' +
	  secs + ' seconds';
	return cd;
}