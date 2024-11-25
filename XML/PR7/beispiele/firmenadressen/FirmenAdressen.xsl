<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html"/>

	<!-- erstes Template, wird fuer Wurzel-Element ausgefuehrt -->
	<xsl:template match="/">
		<html>
			<head>
				<title>Firmenadressen</title>
			</head>
			<body>
				<h1>Alle Firmenadressen (Anzahl: <xsl:value-of select="count(/ADRESSEN/ADRESSE)"/>)</h1>
				<!-- <h1>Firmenadressen in Chemnitz (Anzahl: <xsl:value-of select="count(/ADRESSEN/ADRESSE[ORT='Chemnitz'])"/>)</h1> -->
				<!-- <h1>Firmenadressen Firmename beginnt mit 'C' (Anzahl: <xsl:value-of select="count(/ADRESSEN/ADRESSE[starts-with(FIRMA, 'C')])"/>)</h1> -->
				<table border="1">
					<tr>
						<th>Position</th>
						<th>ID</th>
						<th>Firmenname</th>
						<th>Strasse</th>
						<th>PLZ</th>
						<th>Ort</th>
						<th>Anzahl Mitarbeiter</th>
					</tr>
					<!--  zweites Template ausfuehren, welches nun iterativ die Tabellenzeilen erzeugt -->
					<xsl:call-template name="firmenliste"/> 
				</table>
			</body>
		</html>
	</xsl:template>

	<!-- zweites Template, erzeugt Tabellenzeilen -->
	<xsl:template name="firmenliste">
		<!-- erzeugt so viele Tabellenzeilen, wie gemaess XPath-Ausdruck select="..." zurueckgegeben werden -->
		<xsl:for-each select="/ADRESSEN/ADRESSE">
			<!-- <xsl:for-each select="/ADRESSEN/ADRESSE[ORT='Chemnitz']"> -->
			<!-- <xsl:for-each select="/ADRESSEN/ADRESSE[starts-with(FIRMA,'C')]"> -->
			<xsl:sort select="FIRMA"/>
			<!-- <xsl:sort select="ORT"/> -->
			<tr>
				<td><xsl:value-of select="position()"/></td>
				<td><xsl:value-of select="ID"/></td>
				<td><xsl:value-of select="FIRMA"/></td>
				<td><xsl:value-of select="STRASSE"/></td>
				<td><xsl:value-of select="PLZ"/></td>
				<td><xsl:value-of select="ORT"/></td>
				<td>
					<!-- hier wird die Tabellenzelle rot eingefaerbt, wenn es mehr als 100 Mitarbeiter gibt -->
					<xsl:if test="ANZ_MITARBEITER > 100">
						<xsl:attribute name="bgcolor">red</xsl:attribute>
					</xsl:if>
					<xsl:value-of select="ANZ_MITARBEITER"/>
				</td>
			</tr>
		</xsl:for-each>	
	</xsl:template>

</xsl:stylesheet>
