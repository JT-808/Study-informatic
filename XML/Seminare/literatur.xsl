<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    
    <!-- Wurzel + Header + Body-->
    <xsl:template match="/">
        <html>
        <head>
            <title>Literatur</title>
            </head>
        <body>
        <xsl:apply-templates/>
        </body>
        </html>
    </xsl:template>

    <xsl:template match ="werk">
    <h3>
    <xsl:value-of select="@werk_id:"/>
    <xsl:value-of select="typ"/>
    </h3>
    <p>autoren: <xsl:value-of select="autoren"/></p>
    <p>titel: <xsl:value-of select="titel"/></p>
    <p>verlag: <xsl:value-of select="verlag"/></p>
    <p>jahr: <xsl:value-of select="jahr"/></p>

    </xsl:template>
</xsl:stylesheet>