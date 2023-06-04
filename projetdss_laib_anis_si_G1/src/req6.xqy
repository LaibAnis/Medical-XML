(: cette requette permet grace au constructeur compté de creer un document xml avec l'element fichepatient qui contient le mantant moyen des consultation pour chaque patient :)


for $x in doc("src//dossiermedicaux.xml")//listdossier/dossier

let $mantant := data($x//mantant)
return 
element fichedossier {
    attribute id { data($x/@idd)},
    element idpatientconcernee { data($x//patientconcernee/@ref) },
    element mantantmoyen { avg($mantant) }
  }

