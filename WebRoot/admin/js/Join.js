$(document).ready(function(){
	$("#name").blur(function(){				//当输入框失去焦点时
		var keyVal = $(this).val();
		if (keyVal.length == 0){
	    $("#public1").css("display","inline");   //如果未输入，显示“不能为空”
	    $("#public1").css("color","red");
	   	} else {$("#public1").css("display","none");}   //否则不显示
	 });
	 $("#sex").blur(function(){
	    var keyVal = $(this).val();
		if (keyVal.length == 0){
	    $("#public2").css("display","inline");
	    $("#public2").css("color","red");
	   	} else {$("#public2").css("display","none");}
	 });
	 $("#room").blur(function(){
	    var keyVal = $(this).val();
		if (keyVal.length == 0){
	    $("#public3").css("display","inline");
	    $("#public3").css("color","red");
	    } else {$("#public3").css("display","none");}
	 });
	 $("#emile").blur(function(){
	    var keyVal = $(this).val();
		if (keyVal.length == 0){
	    $("#public4").css("display","inline");
	    $("#public4").css("color","red");
	    } else {$("#public4").css("display","none");}
	 });
});
$(function(){
	$(".labelc_checkbox").on("click",function(){
		var cb_prt=$(this).parent();
		cb_prt.hasClass("active")? cb_prt.removeClass("active"):cb_prt.addClass("active");
  	});
	var img=document.getElementById("file_img");
	$(".file").on("mouseover",function(){img.className="file_btn";});
	$(".file").on("mouseout",function(){img.className="";});
});

function previewImage(file){
	if (file.files && file.files[0]){
		var img = document.getElementById('file_img');
		var reader = new FileReader();		//读取文件
		reader.onload = function(evt){img.src = evt.target.result;}  //加载文件
		reader.readAsDataURL(file.files[0]);		//文件位置
	}else{ //兼容IE
		file.select();  //表单的file字段被选中
		var src = document.selection.createRange().text;
		var img = document.getElementById('file_img');
		img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;  //滤镜背景图片地址
	}
}
//检测输入框
function check(){
	if (document.Info.name.value==""){
		alert("请输入姓名！");document.Info.name.focus();return false;		//不能为空
	}
	if (document.Info.sex.value==""){
		alert("请输入性别！");document.Info.sex.focus();return false;
	}
	if (document.Info.room.value==""){
		alert("请输入寝室！");document.Info.room.focus();return false;
	}
	var obj = document.getElementsByName("personHobby");
	var objLen= obj.length;
	var objYN;
	var z;
	objYN=false;
	for (z = 0;z < objLen;z++){
		if (obj[z].checked==true) {
			objYN = true;
			break;
		}
	}
	if (objYN==false){
		alert("请至少选择一项技术！");document.Info.add.focus();return false;
	}
	if (document.Info.add.value==""){
		alert("请输入籍贯！");document.Info.add.focus();return false;
	}
	if (Info.born.value==""){
		alert("请输入您的出生日期");Info.born.focus();return false;
	}
	//验证输入框是否为标准日期
	var a = /^(\d{4})-(\d{2})-(\d{2})$/;
	if (!(a.test(Info.born.value))){
		alert("请输入标准日期（如：1980-05-29）");Info.born.focus();return false;
	}
	if (document.Info.id.value==""){
		alert("请输入学号！");document.Info.id.focus();return false;
	}
	//验证输入框是否为正确学号
	var b = /\b\d{12}\b/;
	if (!(b.test(Info.id.value))){
		alert("请输入正确学号！");document.Info.id.focus();return false;
	}
	if (document.Info.class.value==""){
		alert("请输入班级！");document.Info.class.focus();return false;
	}
	if (document.Info.tel.value==""){
		alert("请输入手机号码！");document.Info.tel.focus();return false;
	}
	//验证输入框是否为正确手机号码
	var g = /^1(3|4|5|7|8)\d{9}$/;
	if (!(g.test(Info.tel.value))){
		alert("请输入正确手机号码！");document.Info.tel.focus();return false;
	}
	if (document.Info.qq.value==""){
		alert("请输入qq号！");document.Info.qq.focus();return false;
	}
//	//验证输入框是否为正确qq号
//	var d = /^1[3|4|5|8][0-9]\d{4,8}$/;
//	if (!(d.test(Info.qq.value))){
//		alert("请输入正确qq号！");document.Info.qq.focus();return false;
//	}
	if (Info.emile.value==""){
		alert("请输入邮箱地址！");Info.emile.focus();return false;
	}
	//验证输入框是否为邮箱地址
	var i=Info.emile.value.indexOf("@");
	var j=Info.emile.value.indexOf(".");
	if((i<0)||(i-j>0)||(j<0)){
		alert("您输入的邮箱地址不正确，请重新输入！");Info.emile.value="";Info.emile.focus();return false;
	}
	if(Info.resume.value==""){
		alert("请自我介绍");Info.resume.focus();return false;
	}
	if(Info.ans2.value==""){
		alert("请输入理解");Info.ans2.focus();return false;
	}
	if(Info.ans3.value==""){
		alert("请输入规划");Info.ans3.focus();return false;
	}
	if (document.Info.fileField.value==""){
		alert("请上传照片");document.Info.fileField.focus();return false;
	}
}