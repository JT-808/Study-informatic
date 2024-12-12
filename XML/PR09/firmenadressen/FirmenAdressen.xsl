<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

	<!-- Attribut-Set-Deklarationen -->
	<xsl:attribute-set name="cell-style">
		<xsl:attribute name="border-width">0.5pt</xsl:attribute>
		<xsl:attribute name="border-style">solid</xsl:attribute>
		<xsl:attribute name="border-color">black</xsl:attribute>
	</xsl:attribute-set>

	<xsl:attribute-set name="block-style">
		<xsl:attribute name="font-size">10pt</xsl:attribute>
		<xsl:attribute name="line-height">15pt</xsl:attribute>
		<xsl:attribute name="start-indent">2mm</xsl:attribute>
		<xsl:attribute name="end-indent">2mm</xsl:attribute>
	</xsl:attribute-set>

	<!-- erstes Template zur Formatierung des aeusseren Layouts -->
	<!-- analog zu 'Seite einrichten' in einer Textverarbeitung -->
	<xsl:template match="/">
		<!-- ab hier werden die Formatting Object-Elemente erstellt -->
		<fo:root>
			<!-- A4-Seite formatieren -->
			<fo:layout-master-set>
				<fo:simple-page-master master-name="Standard-A4-Seite" margin-top="1.5cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm" page-width="21cm" page-height="29.7cm">
					<!-- innerer Rahmen -->
					<fo:region-body margin-top="1cm" margin-bottom="1cm" margin-left="1cm" margin-right="1cm"/>
					<fo:region-before region-name="header" extent="1cm"/>
					<fo:region-after region-name="footer" extent="1cm"/>
					<fo:region-start region-name="left" extent="1cm"/>
					<fo:region-end region-name="right" extent="1cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			
			<fo:page-sequence master-reference="Standard-A4-Seite">
				<!-- fliessenden Bereich des Textkoerpers formatieren -->
				<fo:flow flow-name="xsl-region-body">
					<fo:block/>
				</fo:flow>
			</fo:page-sequence>
			
		</fo:root>
	</xsl:template>
	
</xsl:stylesheet>
