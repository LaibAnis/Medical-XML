(: cette requette permet de calculer le chifre d'affaire a partir du mantant des consultation pour chaque dossier :)

for $x in doc("src//dossiermedicaux.xml")//listdossier
let $y := $x/dossier/listeconsultation/consultation/mantant
return sum($y)