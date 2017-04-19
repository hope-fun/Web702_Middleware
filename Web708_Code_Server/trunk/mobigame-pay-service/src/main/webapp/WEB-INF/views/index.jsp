<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div title='Welcome' id="main" class="panel" selected="true">
	<div class="topSpacer"></div>
	<div style="width: 95%;" class="button-01" onclick="$.ui.loadContent('<p:fullurl value="/sample/external"/>', false, false,'flip');">
		<table>
			<tr>
				<td></td>
				<td>Load External Content</td>
				<td></td>
			</tr>
		</table>
	</div>

	<div style="width: 50%;" class="button-01">
		<table>
			<tr>
				<td></td>
				<td>Hello</td>
				<td></td>
			</tr>
		</table>
	</div>
</div>