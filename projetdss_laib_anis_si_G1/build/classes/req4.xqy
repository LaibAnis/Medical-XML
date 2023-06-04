(: cette requette permet d'avoir les patient qui ont l'age maximum parmi les age des patient  du document xml  :)


let $a := distinct-values(data(doc("src//dossiermedicaux.xml")//listepatient/patient/age))
for $x in doc("src//dossiermedicaux.xml")//listepatient/patient
where data($x/age)=max($a)
return $x