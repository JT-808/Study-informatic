#/bin/bash
xmllint -valid -noout messberichte_dtd_intern.xml
if [ -z "$echo"  ]; then
    echo  "Alles OK"
    else echo ""
    exit 1
fi
