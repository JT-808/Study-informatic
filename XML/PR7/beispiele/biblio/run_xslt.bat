@echo off

rem So funktioniert das Aufrufen von Xalan-Java in einer Batch-Datei
rem -classpath XML/PR7/xalan.jar: Verweis auf die jar-Datei
rem org.apache.xalan.xslt.Process: Verweis auf die Java-Klasse
rem -xsltc: Aufruf des XSLT-Compilers
rem -XSL biblio.xsl: Verweis auf das Stylesheet, muss angegeben werden, wenn nicht im XML-Dokument referenziert
java -classpath XML/PR7/xalan.jar org.apache.xalan.xslt.Process -xsltc -IN biblio.xml -XSL biblio.xsl -OUT biblio.html -html
pause
