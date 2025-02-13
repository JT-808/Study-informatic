<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
<html>
    <head>
    <title>  buchsammlung </title>
    </head>
    <body>
        <xsl:call-template name="liste"/>
    </body>
</html>
 </xsl:template>


<xsl:template name="liste">
    <table border="1">
<tr>
<th>titel</th>
<th>autor</th>
<th>jahr</th>
</tr>

 <xsl:for-each select="/buchsammlung/buch">
 <tr>
<td><xsl:value-of select="titel"/></td>
<td><xsl:value-of select="autor"/></td>
<td><xsl:value-of select="jahr"/></td>
</tr>
</xsl:for-each>
</table>
</xsl:template>
</xsl:stylesheet>