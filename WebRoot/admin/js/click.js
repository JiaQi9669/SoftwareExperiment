/**
 * 点击所用到的js
 */

/**
 * 分页跳转
 */
function jump(str) {
	var page = document.getElementsByName("page")[0].value;
	location.href = encodeURI(str + "page=" + page);
}

/**
 * 选中所有的check
 */
function checkAll(field){
	//根据checkbox框的名称，查询得到所有的checkbox对象
	var idCheckboxs = document.getElementsByName("id");
	for(var i=0; i<idCheckboxs.length; i++){
		//判断顶上那个checkbox框的选中状态
		if(field.checked){
			idCheckboxs[i].checked = true;
		}else{
			idCheckboxs[i].checked = false;
		}
	}
}