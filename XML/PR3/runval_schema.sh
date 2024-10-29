#/bin/bash
xmllint -schema biblio_schema.xsd -noout biblio_schema.xml
if [ -z "$echo"  ]; then echo  "Alles OK"
    exit 1
fi
