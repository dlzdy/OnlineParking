//菜单状态切换
var fmid = "fhindex";
var mid = "fhindex";
function siMenu(id,fid,MENU_NAME,MENU_URL){
	if(id != mid){
		$("#"+mid).removeClass();
		mid = id;
	}
	if(fid != fmid){
		$("#"+fmid).removeClass();
		fmid = fid;
	}
	$("#"+fid).attr("class","active open");
	$("#"+id).attr("class","active");
	top.mainFrame.tabAddHandler(id,MENU_NAME,MENU_URL);
//	if(MENU_URL != "druid/index.html"){
		jzts();
//	}
}



