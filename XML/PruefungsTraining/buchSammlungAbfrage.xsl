<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">

        <html>
        <head><title>"Erscheinungsjahr > 2000"</title></head>
        <body>
        <xsl:call-template name = "jahr"/>
        </body>
        </html>

    </xsl:template>

    <xsl:template name = "jahr">

        <table border ="1">
        <tr>
            <th>titel</th>
            <th>autor</th>
            <th>jahr</th>
        </tr>

        <xsl:for-each select="//buch[jahr>'2000']/*">
            <tr>
                <td><xsl:value-of select="titel"/></td>
                <td><xsl:value-of select="autor"/></td>
                <td><xsl:value-of select="jahr"/></td>
            </tr>
        </xsl:for-each>
     
        
        </table>

    
    </xsl:template>

</xsl:stylesheet>