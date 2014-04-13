<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Medicine Demo</title><base>
<script src="<%=basePath%>/resources/jquery-1.8.3.js"></script>
<script src="<%=basePath%>/resources/jquery.form.js"></script>
<script type="text/javascript">
console.log("<%=basePath%>/medicine/saveMedicne");
	function save(){
		
		$("#medicineForm").ajaxForm({
			url : "<%=basePath%>/medicine/saveMedicne",
			dataType : "json",	 
			success:function(data){
				
				alert("1");
			},
			error:function() {
				
				alert("保存时发生错误！");
			}
		});
	}
</script>
</head>
<body>
	<!-- onsubmit="return check('add');" -->
	<form id="medicineForm" method="post" >
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>名称：</td>
				<td><input type="text" id="medicineName" name="medicineName" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td>价格：</td>
				<td><input type="text" id="price" name="price" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td>数量：</td>
				<td><input type="text" id="count" name="count" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" onclick="save()" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>