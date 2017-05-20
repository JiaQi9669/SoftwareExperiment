$(document).ready(
		function() {
			/* 获取学院 */
//			alert("新的js");
			$.post("linkageToObtainAction_getDepartment.action",
					function(data) {
						var jsonObj = eval("(" + data + ")");
						for ( var i = 0; i < jsonObj.length; i++) {
							// var $option = $("<option></option>");
							// $option.attr("value", jsonObj[i].departmentID);
							// $option.text(jsonObj[i].departmentName);
							// $("#department").append($option);
							document.getElementById("department").options
									.add(new Option(jsonObj[i].departmentName,
											jsonObj[i].departmentID));
						}
					});
			/* 根据学院获取专业 */
			$("#department").change(function() {
				$.post("linkageToObtainAction_getMajor.action", {
					departmentID : $("#department").val()
				}, function(data) {
					/* 清空专业 */
					$("#major option[value!=' ']").remove();
					// alert("first");
					// alert("second");
					// document.getElementById("major").options.remove();
					/* 清空班级 */
					$("#classRoom option[value!=' ']").remove();
					var jsonObj = eval("(" + data + ")");
					var $option = $("<option></option>");
					$option.attr("value", 0);
					$option.text("全部");
					$("#major").append($option);
					for ( var i = 0; i < jsonObj.length; i++) {
						var $option = $("<option></option>");
						$option.attr("value", jsonObj[i].majorID);
						$option.text(jsonObj[i].majorName);
						$("#major").append($option);
					}
				});
			});
			/* 根据专业获取班级 */
			$("#major").change(function() {
				$.post("linkageToObtainAction_getClassRoom.action", {
					majorID : $("#major").val()
				}, function(data) {
					/* 清空班级 */
					$("#classRoom option[value!='']").remove();
					var jsonObj = eval("(" + data + ")");
					var $option = $("<option></option>");
					$option.attr("value", 0);
					$option.text("全部");
					$("#classRoom").append($option);
					for ( var i = 0; i < jsonObj.length; i++) {
						var $option = $("<option></option>");
						$option.attr("value", jsonObj[i].classID);
						$option.text(jsonObj[i].classRoomName);
						$("#classRoom").append($option);
					}
				});
			});
			/* 根据班级获取学生 */
			$("#classRoom").change(function() {
				$.post("linkageToObtainAction_getStudent.action", {
					classID : $("#classRoom").val()
				}, function(data) {
					/* 清空学生 */
					$("#student option[value!='']").remove();
					var jsonObj = eval("(" + data + ")");
					var $option = $("<option></option>");
//					$option.attr("value", 0);
//					$option.text("全部new");
//					$("#student").append($option);
					for ( var i = 0; i < jsonObj.length; i++) {
						var $option = $("<option></option>");
						$option.attr("value", jsonObj[i].id);
						$option.text(jsonObj[i].studentName);
						$("#student").append($option);
					}
				});
			});
			/* 获取机房 */
			$.post("linkageToObtainAction_getComputerRoom.action", function(
					data) {
				/* 清空机房 */
				$("#computerRoom option[value!='']").remove();
				var jsonObj = eval("(" + data + ")");
				var $option = $("<option></option>");
				$option.attr("value", 0);
				$option.text("全部");
				$("#computerRoom").append($option);
				for ( var i = 0; i < jsonObj.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", jsonObj[i].computerRoomID);
					$option.text(jsonObj[i].roomNo);
					$("#computerRoom").append($option);
				}
			});
			/* 获取课程 */
			$.post("linkageToObtainAction_getCourse.action", function(
					data) {
				/* 清空机课程*/
				$("#course option[value!='']").remove();
				var jsonObj = eval("(" + data + ")");
				var $option = $("<option></option>");
				$option.attr("value", 0);
				$option.text("全部");
				$("#course").append($option);
				for ( var i = 0; i < jsonObj.length; i++) {
					var $option = $("<option></option>");
					$option.attr("value", jsonObj[i].courseID);
					$option.text(jsonObj[i].courseName);
					$("#course").append($option);
				}
			});
		});