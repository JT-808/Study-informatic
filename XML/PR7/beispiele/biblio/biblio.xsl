<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html"/>

	<!-- erstes Template, wird ausgefuehrt, wenn Wurzel-Element (root) in der XML-Datei erkannt wird -->
	<xsl:template match="/">

		<!-- erzeugt HTML-Seite mit header und body --> 
		<html>
			<head>
				<title>Bücherliste</title>
			</head>

			<body>
				<h1>Bücher:</h1>
				<hr/>
				<!-- der Kontext ist das Wurzel-Element -->
				<!-- für alle Kindelemente ("buch") werden die passenden Templates ausgefuehrt -->
				<xsl:apply-templates />
			</body>
		</html>

	</xsl:template>

	<!-- zweites Template, wird für alle Elemente "buch" ausgefuehrt --> 
	<xsl:template match="buch">
	
		<h3>
			<xsl:value-of select="titel"/>
		</h3>
		<p>Kürzel: <xsl:value-of select="kuerzel"/></p>
		<p>Autoren: <xsl:value-of select="autoren"/></p>
		<p>Verlag: <xsl:value-of select="verlag"/></p>
		<p>ID: <xsl:value-of select="@buch_id"/></p>
		<hr/>
		
	</xsl:template>
	 
</xsl:stylesheet>
