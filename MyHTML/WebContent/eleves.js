var eleves = [ {
	"id" : 1,
	"nom" : "MOKHTARI",
	"prenom" : "Nadir",
	"age" : 26,
	"situationFamiliale" : "C"
}, {
	"id" : 2,
	"nom" : "GENSE",
	"prenom" : "Aurélie",
	"age" : 24,
	"situationFamiliale" : "C"
}, {
	"id" : 3,
	"nom" : "D'ORCHYMONT",
	"prenom" : "Margaux",
	"age" : 24,
	"situationFamiliale" : "P"
} ];

var situationFamiliales = [
	{
		"key":"C",
		"value":"Célibataire"
	},
	{
		"key":"P",
		"value":"Pacsé"
	},
	{
		"key":"D",
		"value":"Divorcé"
	},
	{
		"key":"M",
		"value":"Marié"
	},
	{
		"key":"U",
		"value":"Union libre"
	}
];

function findSituationFamiliale(key) {
	
	for(var situationFamiliale of situationFamiliales) {
		if(situationFamiliale.key == key) {
			return situationFamiliale.value;
		}
	}
	
	return "";
};

function initTable() {
	eleveForm.style.visibility='visible'; 

	var tabEleves = document.getElementById("tabEleves").getElementsByTagName(
			"tbody")[0];

	var rows = tabEleves.childNodes;

	for (var i = rows.length - 1; i > 1; i--) {
		var row = rows[i];
		console.log(i + ":" + row);
		tabEleves.removeChild(row);
	}

	for (var i = 0; i < eleves.length; i++) {
		var eleve = eleves[i];
		var row = document.createElement("tr");
		var idCell = document.createElement("td");
		idCell.appendChild(document.createTextNode(eleve.id));
		row.appendChild(idCell);

		var nomCell = document.createElement("td");
		nomCell.appendChild(document.createTextNode(eleve.nom));
		row.appendChild(nomCell);

		var prenomCell = document.createElement("td");
		prenomCell.appendChild(document.createTextNode(eleve.prenom));
		row.appendChild(prenomCell);

		var ageCell = document.createElement("td");
		ageCell.appendChild(document.createTextNode(eleve.age));
		row.appendChild(ageCell);

		var situationFamilialeCell = document.createElement("td");
		situationFamilialeCell.appendChild(document
				.createTextNode(findSituationFamiliale(eleve.situationFamiliale)));
		row.appendChild(situationFamilialeCell);
		// 3. gérer l'édition en ouvrant le formulaire et en renseignant les
		// champs de formulaire avec la ligne sélectionnée
		// la validation du formulaire sur un élève doit modifier le tableau
		// javascript et rafraichir le tableau html correspondant
		
		// 5. rajouter une confirmation à la suppression en utilisant les
		// fenêtres modal de bootstrap
		var buttonsCell = document.createElement("td");

		buttonsCell.innerHTML = "<div><button type='button' onclick='editEleve("+eleve.id+")'>Edit</button><button type='button' onclick='deleteEleve("
				+ eleve.id
				+ ")'>Delete</button></div>";
		row.appendChild(buttonsCell);


		tabEleves.appendChild(row);
	}
	
	var situationFamilialeSelect = document.getElementById("situationFamiliale");
	
	situationFamilialeSelect.length = 0;
	
	for(var situationFamiliale of situationFamiliales) {
		var option = document.createElement("option");
		option.value = situationFamiliale.key;
		option.text = situationFamiliale.value;
		
		situationFamilialeSelect.add(option);
	}
}

function addEleve() {
	
	cancelEleve();
	
	document.getElementById("id").readOnly = false;
	
	var eleveForm = document.getElementById("eleveForm");
	eleveForm.style.visibility='visible';
	
	// 1. renseigner la liste déroulante des situations familiales à partir du
	// tableau javascript
	
}

function editEleve(id) {
	var eleve;
	
	for(eleve of eleves) {
		if(eleve.id == id) {
			break;
		}
	}
	
	document.getElementById("id").value = eleve.id;
	document.getElementById("nom").value = eleve.nom;
	document.getElementById("prenom").value = eleve.prenom;
	document.getElementById("age").value = eleve.age;
	document.getElementById("situationFamiliale").value = eleve.situationFamiliale;
	
	document.getElementById("id").readOnly = true;
	
	var eleveForm = document.getElementById("eleveForm");
	eleveForm.style.visibility='visible';
}

function saveEleve() {
	var eleve = {};
	
	eleve.id = document.getElementById("id").value;
	eleve.nom = document.getElementById("nom").value;
	eleve.prenom = document.getElementById("prenom").value;
	eleve.age = document.getElementById("age").value;
	eleve.situationFamiliale = document.getElementById("situationFamiliale").value;
	
	var index;
	var find = false;
	for(index=0;index<eleves.length;index++) {
		var currentEleve = eleves[index];
		if(currentEleve.id == eleve.id) {
			find = true;
			break;
		}
	}
	
	if(find) {
		eleves[index] = eleve;
	} else {
		eleves.push(eleve);
	}
	console.log(eleves);
	
	initTable();
	
	cancelEleve();
}

function deleteEleve(id) {
	var i
	for (i = 0; i < eleves.length; i++) {
		var eleve = eleves[i];
		if (eleve.id == id) {
			break;
		}
	}

	eleves.splice(i, 1);

	initTable();
}

function cancelEleve() {
	var eleveForm = document.getElementById("eleveForm");
	eleveForm.style.visibility='hidden'; 
	
	document.getElementById("id").value = "";
	document.getElementById("nom").value = "";
	document.getElementById("prenom").value = "";
	document.getElementById("age").value = "";
	document.getElementById("situationFamiliale").selectedIndex = -1;
}

initTable();