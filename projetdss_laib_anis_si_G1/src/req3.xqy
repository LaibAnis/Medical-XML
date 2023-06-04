(: cette requette permet d'avoir  la date de creation minimale d'un  dossier dans le document xml  :)


(
let $a := doc("src//dossiermedicaux.xml")/dossiermidecaux/listdossier/dossier/informationadministrative/datedecreation
for $x in doc("src//dossiermedicaux.xml")/dossiermidecaux/listdossier/dossier/informationadministrative/datedecreation
where data($x/annee)=min(data($a/annee))
order by data($x/mois) , data($x/jour)
return $x)[1]