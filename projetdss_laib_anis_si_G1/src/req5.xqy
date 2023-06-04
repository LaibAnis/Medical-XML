(: cette requette permet d'avoir des balise personaliser selon le type du lieux de travaille des medecins :)


let $a := distinct-values(data(doc("src//dossiermedicaux.xml")//listepatient/patient/age))
for $x in doc("src//dossiermedicaux.xml")//listemedecin/medecin//lieuxdetravaille/lieux
return if($x/@type="cabinet") 
then <cabinet>{data($x/nom)}</cabinet>
else <etablissementdesante>{data($x/nom)}</etablissementdesante>
