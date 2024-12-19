<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">

	<xsl:template match="/">
		<fo:root>
			<!-- ab hier werden die Formatting Object-Elemente erstellt -->

            <!-- Seitenlayout-->


			<fo:layout-master-set>
				<fo:simple-page-master master-name="Erste Seite" margin-top="2cm" margin-bottom="2cm" margin-left="2.5cm" margin-right="2.5cm" page-width="21cm" page-height="29.7cm">
					<fo:region-body margin-top="1.5cm" margin-bottom="1.5cm" margin-left="1cm" margin-right="1cm"/>
                    <!-- kopfzeile-->
                    <fo:region-before region-name="header" extent="3cm"/>
                    <!-- Fusszeile-->
                    <fo:region-after region-name="footer" extent="2cm"/>
                    <!-- rechter Randbereich-->
                    <fo:region-end region-name="right" extent="3cm"/>
				</fo:simple-page-master>
			</fo:layout-master-set>

            <!-- Seiten-->
			<fo:page-sequence master-reference="Erste Seite">
            <!-- Kopfzeile-->
            <fo:static-content flow-name="header" text-align="center">
                <fo:block font-size="16pt">Das ist die Kopfzeile</fo:block>
                <fo:block font-size="14pt">Das ist die zweite Kopfzeile</fo:block>
            </fo:static-content>
            <!-- ergänzen sie eine Fußzeile-->
            <!-- rechter Ranfbereich-->
            <fo:static-content flow-name="right" text-align="center">
                <fo:block font-size="10pt" color="rgb(0,255,0)">Das ist die erste Randbemerkung</fo:block>
                <fo:block font-size="8pt" color="rgb(0,255,0)">Das ist die zweite Randbemerkung</fo:block>
            </fo:static-content>
            <!-- SeitenInhalt-->
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-size="12pt" background-color="rgb(90%, 90%, 0%)">
						<xsl:apply-templates/>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	
    <xsl:template match="buch">
        <fo:block>
        Titel:<xsl:value-of select="titel"/>
        </fo:block>
    <fo:block font-family="Helvetica, Arial,sans-serif" font-size="14pt" text-align="right">
    kürzel: <xsl:value-of select="kuerzel"/>
    </fo:block>
      <fo:block font-family="Times, 'Times New Roman', serif" font-size="14pt" text-align="right">
    Autoren: <xsl:value-of select="autoren"/>
    </fo:block>
      <fo:block background-color="rgb(30%,60%,10%)">
    Verlag: <xsl:value-of select="verlag"/>
    </fo:block>
      <fo:block color="rgb(0,0,255)">
    ID: <xsl:value-of select="@buch_id"/>
    </fo:block>

    
    </xsl:template>



</xsl:stylesheet>
