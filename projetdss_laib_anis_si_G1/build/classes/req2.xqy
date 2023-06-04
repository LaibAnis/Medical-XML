(: cette requette permet d'avoir les ID des dossier qui ont quellque traitement DOLIPRANE comme traitement ponctuelle  :)

for $x in doc("src//dossiermedicaux.xml")/dossiermidecaux/listdossier/dossier
where some $i in $x/listetraitementponctuel/traitement
satisfies contains($i/nom,"doliprane")
return data($x/@idd)