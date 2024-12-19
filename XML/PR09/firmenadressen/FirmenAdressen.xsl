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
			<!-- statische Bereiche fuer Kopf- und Fusszeile formatieren-->
			<fo:static-content flow-name="header" text-align="center">
			<fo:block font-size="16pt">XSL-FO-Praktikum</fo:block>
			</fo:static-content>

			<fo:static-content flow-name="footer" text-align="right">
			
			<!-- Seitennummerierung mit fo:page-numver und fo:page-numver-citation-->
			<fo:block font-size="14pt">Seite<fo:page-number/>
			von <fo:page-number-citation ref-id="LastPage"/>
			</fo:block>
			</fo:static-content>


				<!-- fliessenden Bereich des Textkoerpers formatieren -->
				<fo:flow flow-name="xsl-region-body">
				<xsl:apply-templates/>
					<fo:block id="LastPage"/>
				</fo:flow>
			</fo:page-sequence>
			
		</fo:root>
	</xsl:template>

	<!-- zweites Template zur Ausgabe der Ueberschrift,Tabellenheader und Tabellenkörper-->
	<xsl:template match="ADRESSEN">
	<!-- bsp. fuer Inline-Rotfärbung-->
	<fo:block>
	<fo:inline color="red">Firmenadressen in Mittweida und Chemnitz</fo:inline> (Anzahl:
	<xsl:value-of select="count(ADRESSE[ORT='Mittweida' or ORT='Chemnitz'])"/>)
	</fo:block>
	<!-- Tabellenstruktur - layout-->
	<fo:table border-style="solid" table-layout="fixed" width="15">
		<fo:table-column column-width="1.5cm"/>
		<fo:table-column column-width="5.4cm"/>
		<fo:table-column column-width="2.8cm"/>
		<fo:table-column column-width="3.8cm"/>
		<fo:table-column column-width="1.4cm"/>
		<fo:table-header>
			<xsl:call-template name="table-head"/>
		</fo:table-header>
		<fo:table-body>
			<xsl:apply-templates select="ADRESSE[ORT='Mittweida' or ORT='Chemnitz']">
				<xsl:sort select="FIRMA"/>
			</xsl:apply-templates>
		</fo:table-body>
	</fo:table>
	</xsl:template>
	

	<!-- drittes Template zur Formatierung und statischen Ausgabe des Tabellenkopfes-->
	<xsl:template name="table-head">
		<fo:table-row background-color="rgb(0%,50%,0%)">
			<fo:table-cell xsl:use-attribute-sets="cell-style">
			<fo:block xsl:use-attribute-sets="block-style" text-align="center">ID</fo:block>
			</fo:table-cell>
			<xsl:use-attribute-sets="cell-style">
			<fo:block xsl:use-attribute-sets="block-style" text-align="center">Firmenname</fo:block>
			</fo:table-cell>
			<fo:table-cell xsl:use-attribute-sets="cell-style">
			<fo:block xsl:use-attribute-sets="block-style" text-align="center">Ort</fo:block>
			</fo:table-cell>
			<fo:table-cell xsl:use-attribute-sets="cell-style">
			<fo:block xsl:use-attribute-sets="block-style" text-align="center">Telefon</fo:block>
			</fo:table-cell>
			<fo:table-cell xsl:use-attribute-sets="cell-style">
			<fo:block xsl:use-attribute-sets="block-style" text-align="center">Anz. MA</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</sxl:template>


</xsl:stylesheet>
