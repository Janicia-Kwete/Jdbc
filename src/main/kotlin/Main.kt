package org.example

import org.example.jdbc.BDD
import org.example.model.dao.EtudiantDAO

val db = BDD()
val etudiantDAO = EtudiantDAO()
fun main() {
    db.getConnection()
    val etudiants = etudiantDAO.findAll()
    for (etudiant in etudiants) {
        println("${etudiant.id} => ${etudiant.nom}  ${etudiant.prenom}")
    }


    db.close()
}
