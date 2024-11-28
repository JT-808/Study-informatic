<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html"/>

<xsl:template match="/">
<html>
	<head>
		<title>Links für das Modul Datenrepräsentation</title>
	</head>
	<body>
		<h1>Links für das Modul Datenrepräsentation</h1>
		<!-- Template tableHeader ausfuehren -->
		 <xsl:call-template name="tableHeader"/>
	</body>
</html>
</xsl:template>

		<xsl:template name="tableHeader">
		<table border = "1">
			<tr>
				<th>Position</th>
				<th>Titel</th>
				<th>Link</th>
				<th>Beschreibung</th>
			</tr>
			<!-- Template tableBody ausfuehren -->
			 <xsl:call-template name="tableBody"/>
		</table>
		</xsl:template>


<xsl:template name="tableBody">
	<!-- nur Links fuer das Modul Datenrepraesentation auswaehlen -->
	 <xsl:for-each select="links/titel[modul='DTA']">  <!--// Filtere alle mit modul DTA-->
	<tr>
		<!-- Funktion position() aufrufen, um die Knoten-Position im aktuellen Kontext zu ermitteln -->
		<td><xsl:value-of select="position()"/></td>
		<td><xsl:value-of select="titel"/></td>
		<td>
		<!-- Attribut href hinzufuegen-->
			<a>
				<xsl:attribute name="href">
					<xsl:value-of select="ref"/>
				</xsl:attribute>
				<xsl:value-of select="ref"/>
			</a>
		</td>
		<td><xsl:value-of select="description"/></td>
	</tr>

</xsl:for-each>

</xsl:template>
	    

</xsl:stylesheet>
