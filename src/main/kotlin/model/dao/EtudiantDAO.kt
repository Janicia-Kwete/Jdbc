package org.example.model.dao

import org.example.db
import org.example.jdbc.BDD
import org.example.model.entity.Etudiant


class EtudiantDAO (val bdd: BDD = db) {


    fun findAll(): MutableList<Etudiant> {

        // Crée une liste vide pour stocker les étudiants
        val result = mutableListOf<Etudiant>()

        // Requête SQL pour récupérer tous les étudiants
        val sql = "SELECT * FROM etudiant"

        // Prépare la requête SQL
        val requetePreparer = bdd.connectionBDD!!.prepareStatement(sql)

        // Exécute la requête et récupère les résultats
        val resultatRequete = bdd.executePreparedStatement(requetePreparer)


        // Vérifie que le résultat existe
        if (resultatRequete != null) {
            // Parcourt chaque ligne du résultat
            while (resultatRequete.next()) {

                // Récupère l'identifiant
                val id = resultatRequete.getInt("id")

                // Récupère le nom
                val nom = resultatRequete.getString("nom")

                // Récupère le prenom
                val prenom = resultatRequete.getString("prenom")


                // Récupère l'adresse e-mail
                val email = resultatRequete.getString("email")

                // Récupère la date de naissance
                val dateNaissance =
                    resultatRequete.getDate("date_naissance")

                // Crée un étudiant et l'ajoute à la list

                result.add(Etudiant(id,nom,prenom,email,dateNaissance.toLocalDate()))

            }
        }

        // Ferme la requête préparée
        requetePreparer.close()

        // Retourne la liste des étudiants
        return result
    }

}