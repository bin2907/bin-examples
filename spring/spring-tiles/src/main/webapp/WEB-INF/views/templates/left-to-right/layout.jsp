
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

	<table width="100%">

		<tr>

			<td><tiles:insertAttribute name="header" /></td>
			<td><tiles:insertAttribute name="body" /></td>
			<td><tiles:insertAttribute name="footer" /></td>

		</tr>

	</table>

</body>
</html>
