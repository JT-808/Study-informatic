<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

	<xsl:template match="/">
		<fo:root>
			<!-- ab hier werden die Formatting Object-Elemente erstellt -->
			<fo:layout-master-set>
				<fo:simple-page-master master-name="Erste Seite" margin-top="2cm" margin-bottom="2cm" margin-left="2.5cm" margin-right="2.5cm" page-width="21cm" page-height="29.7cm">
					<fo:region-body margin-top="1.5cm" margin-bottom="1.5cm" margin-left="1cm" margin-right="1cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="Erste Seite">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="12pt" background-color="rgb(90%, 90%, 0%)">
						Hallo Welt!
						<!-- xsl:apply-templates/ -->
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	
</xsl:stylesheet>
