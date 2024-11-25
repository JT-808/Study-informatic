<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html"/>

	<!-- erstes Template, wird fuer Wurzel-Element ausgefuehrt -->
	<xsl:template match="/">
		<html>
			<head>
				<title>Messberichte</title>
			</head>
			<body>
				<xsl:apply-templates select="/messberichte/messbericht"/>
			</body>
		</html>
	</xsl:template>

	<!-- zweites Template, wird fuer Messbericht ausgefuehrt -->
	<xsl:template match = "messbericht">
		<hr/>
		<h1>Messbericht-Nr.: <xsl:value-of select="@mb_id"/></h1>
		<xsl:call-template name="kopfdaten"/>
		<xsl:call-template name="messwerte"/>
		<xsl:call-template name="pruefergebnis"/>
	</xsl:template>

	<!-- drittes Template, wird fuer Kopfdaten ausgefuehrt -->
	<xsl:template name = "kopfdaten">
		<h2>Kopfdaten</h2>
		<table border="1">
			<tr>
				<td align="right"><b>Messbericht-Nr.</b></td>
				<td><xsl:value-of select="@mb_id"/></td>
				<td align="right"><b>Artikel-ID</b></td>
				<td><xsl:value-of select="kopfdaten/artikeldaten/artikel/@artikel_id"/></td>
			</tr>
			<tr>
				<td align="right"><b>Datum</b></td>
				<td><xsl:value-of select="@pruefdatum"/></td>
				<td align="right"><b>Zeichnungs-Nr.</b></td>
				<td><xsl:value-of select="kopfdaten/artikeldaten/artikel/@zeichnungs_nr"/></td>
			</tr>
			<tr>
				<td align="right"><b>Prüfer</b></td>
				<td><xsl:value-of select="kopfdaten/prueferdaten/@pr_name"/></td>
				<td align="right"><b>Bezeichnung</b></td>
				<td><xsl:value-of select="kopfdaten/artikeldaten/artikel/art_bezeichnung"/></td>
			</tr>
			<tr>
				<td align="right"><b>E-Mail</b></td>
				<td><xsl:value-of select="kopfdaten/prueferdaten/@email"/></td>
				<td align="right"><b>Prüfplan-ID</b></td>
				<td><xsl:value-of select="kopfdaten/pruefplandaten/@ppl_id"/></td>
			</tr>
			<tr>
				<td align="right"><b>Personal-ID</b></td>
				<td><xsl:value-of select="kopfdaten/prueferdaten/@pers_id"/></td>
				<td align="right"><b>Lieferanten-ID</b></td>
				<td><xsl:value-of select="kopfdaten/lieferantendaten/@lief_id"/></td>
			</tr>
			<tr>
				<td align="right"><b>Arbeitszeitverbrauch</b></td>
				<td><xsl:value-of select="kopfdaten/arbeitszeit"/>&#160;<xsl:value-of select="kopfdaten/arbeitszeit/@dimension"/></td>
				<td align="right"><b>Lieferant</b></td>
				<td><xsl:value-of select="kopfdaten/lieferantendaten/lieferantenname"/></td>
			</tr>
		</table>
	</xsl:template>

	<!-- viertes Template, wird fuer Messwertdaten ausgefuehrt -->
	<xsl:template name = "messwerte">
		<h2>Messwertdaten</h2>
		<table border="1">
			<tr>
				<th>Prüfmerkmal</th>
				<th>Dimension</th>
				<th>Lfd-Nr.</th>
				<th>Messwert</th>
			</tr>
			<xsl:call-template name="pruefmerkmale" />
		</table>
	</xsl:template>

	<!-- fuenftes Template, wird fuer Pruefmerkmale ausgefuehrt -->
	<xsl:template name= "pruefmerkmale">
		<xsl:for-each select="messwertdaten/pruefmerkmal">
			<xsl:call-template name="pruefmerkmal"/>
		</xsl:for-each>
	</xsl:template>

	<!-- sechstes Template, wird fuer Pruefmerkmal ausgefuehrt -->
	<xsl:template name = "pruefmerkmal">
		<xsl:for-each select="pm_wert">
			<tr>
				<td><xsl:value-of select="../@pm_name"/></td>
				<td><xsl:value-of select="../@pm_dimension"/></td>
				<td><xsl:value-of select="@lfd_nr"/></td>
				<td><xsl:value-of select="."/></td>
			</tr>
		</xsl:for-each>
		<tr>
			<td><xsl:value-of select="../@pm_name"/></td>
			<td><xsl:value-of select="../@pm_dimension"/></td>
			<td><b>Mittelwert</b></td>
			<!-- Berechnung des Mittelwertes waehrend der Transformation -->
			<td><b><xsl:value-of select="sum(pm_wert) div count(pm_wert)"/></b></td>
		</tr>
	</xsl:template>

	<!-- siebentes Template, wird fuer Pruefergebnis ausgefuehrt -->
	<xsl:template name = "pruefergebnis">
		<h2>Prüfergebnis:</h2>
		<h3>Einstufung: <xsl:value-of select="pruefergebnis/@einstufung"/></h3>
		<h3>Bemerkungen:</h3>
		<xsl:value-of select="pruefergebnis/bemerkungen"/>
		<!-- Nacharbeitsdatum nur einfuegen wenn Nacharbeit erforderlich -->
		<xsl:if test = "pruefergebnis/@einstufung='Nacharbeit'">	
			<h3>Nacharbeitsdatum: <xsl:value-of select="pruefergebnis/nacharbeitsdatum"/></h3>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>
