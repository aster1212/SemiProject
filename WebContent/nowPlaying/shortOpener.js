/* short opener */
var bo1 = false;
var bo2 = false;
var bo3 = false;
var bo4 = false;

var str = "test";
var src;

function shortClick(obj) {
	location.href="fullViewAction.action?"+src;
}
function sc1(obj) {
	if(!bo1 || !(str==obj)){
		str = obj;
		src = obj.id;
		bo1=true;
		bo2=false;
		bo3=false;
		bo4 = false;
		
		document.getElementById('short1').innerHTML=document.getElementById('sp'+src).innerHTML;
		
		document.getElementById('short1').style.display='inline-block';
		document.getElementById('short2').style.display='none';
		document.getElementById('short3').style.display='none';
	}else{
		bo1=false;
		document.getElementById('short1').style.display='none';
	}
}
function sc2(obj) {
	
	if(!bo2 || !(str==obj)){
		
		
		str = obj;
		src = obj.id;
		bo1=false;
		bo2=true;
		bo3=false;
		bo4 = false;
		
		document.getElementById('short2').innerHTML=document.getElementById('sp'+src).innerHTML;

		document.getElementById('short1').style.display='none';
		document.getElementById('short2').style.display='inline-block';
		document.getElementById('short3').style.display='none';
	}else{
		bo2=false;
		document.getElementById('short2').style.display='none';
	}
}
function sc3(obj) {
	if(!bo3 || !(str==obj)){
		str = obj;
		src = obj.id;
		bo1=false;
		bo2=false;
		bo3=true;
		bo4 = false;
		
		document.getElementById('short3').innerHTML=document.getElementById('sp'+src).innerHTML;

		document.getElementById('short1').style.display='none';
		document.getElementById('short2').style.display='none';
		document.getElementById('short3').style.display='inline-block';
	}else{
		bo3=false;
		document.getElementById('short3').style.display='none';
	}
}


var src2;
function mover(obj){
	src2 = obj.id;
	obj.style.background='black';
	document.getElementById("poster"+src2).classList.add('opClass');
	document.getElementById("hover"+src2).style.visibility='visible';
}
function mout(obj){
	document.getElementById("poster"+src2).classList.remove('opClass');
	document.getElementById("hover"+src2).style.visibility='hidden';
}








