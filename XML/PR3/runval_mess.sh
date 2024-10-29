#/bin/bash
xmllint -schema messberichte_schema.xsd -noout messberichte_schema.xml
if [ -z "$echo"  ]; then echo  "Alles OK"
    exit 1
fi
