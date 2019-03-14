(function(){
	var current=0;
	var max=0;
	var container;
	
	function init(){
		container = jQuery(".slide ul");
		max = container.children().length;
		
		events();
	}
	function events()
	{
		jQuery("button.prev").on("click",prev);
		jQuery("button.next").on("click",next);
	}
	
	function prev(e)
	{
		current--;
		if(current < 0)
			current = 1;
		
		/*
		if(current<0)
			current=0;*/
		animate();
			
	}
	function next(e)
	{
		current++;
		if(current > 1)
			current = 0;
		
		/*
		if(current>max-1)
			current=max-1;*/
		animate();
	}
	function animate()
	{
		var moveX = current*800;
		TweenMax.to(container, 0.8, {marginLeft:-moveX, ease:Expo.easeOut} );
	}
	jQuery( document ).ready( init );
})(); 