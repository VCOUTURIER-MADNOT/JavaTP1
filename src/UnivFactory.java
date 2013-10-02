import java.util.ArrayList;

import universite.administratif.*;
import universite.personnel.*;
import universite.batiment.*;


public class UnivFactory {

	// DEPARTEMENT
	public static Departement createDepartement() {
		return new Departement();
	}
	
	public static Departement createDepartement( ArrayList<Enseignant> _enseignants ) {
		return new Departement(_enseignants);
	}
	
	public static Departement createDepartement( Departement _departement ) {
		return new Departement(_departement);
	}
	
	// LABORATOIRE
	public static Laboratoire createLaboratoire() {
		return new Laboratoire();
	}
	
	public static Laboratoire createLaboratoire( ArrayList<Chercheur> _chercheurs ) {
		return new Laboratoire(_chercheurs);
	}
	
	public static Laboratoire createLaboratoire( Laboratoire _laboratoire ) {
		return new Laboratoire(_laboratoire);
	}
	
	// UFR
	public static UFR createUFR() {
		return new UFR(  );
	}
	
	public static UFR createUFR( ArrayList<Batiment> _batiments, ArrayList<Departement> _departements ) {
		return new UFR( _batiments, _departements );
	}
	
	public static UFR createUFR( UFR _ufr ) {
		return new UFR( _ufr );
	}
	
	// UNIVERSITE
	public static Universite createUniversite() {
		return new Universite();
	}
	
	public static Universite createUniversite(ArrayList<UFR> _ufrs, ArrayList<Laboratoire> _laboratoires, ArrayList<Departement> _departements) {
		return new Universite(_ufrs, _laboratoires, _departements);
	}
	
	public static Universite createUniversite(Universite _universite) {
		return new Universite(_universite);
	}
	
	// BATIMENT
	public static Batiment createBatiment() {
		return new Batiment();
	}

	public static Batiment createBatiment(ArrayList<Salle> _salles) {
		return new Batiment( _salles );
	}

	public static Batiment createBatiment(Batiment _batiment) {
		return new Batiment( _batiment );
	}
	
	// BUREAU
	public static Bureau createBureau() {
		return new Bureau();
	}

	public static Bureau createBureau(ArrayList<Personnel> _personnel) {
		return new Bureau( _personnel );
	}

	public static Bureau createBureau(Bureau _bureau) {
		return new Bureau( _bureau );
	}
	
	// SALLECOURS
	public static SalleCours createSalleCours() {
		return new SalleCours();
	}

	public static SalleCours createSalleCours(int _nbPlaces) {
		return new SalleCours(_nbPlaces);
	}

	public static SalleCours createSalleCours(SalleCours _salleCours) {
		return new SalleCours(_salleCours);
	}
	
	// SALLEREUNION
	public static SalleReunion createSalleReunion() {
		return new SalleReunion();
	}

	public static SalleReunion createSalleReunion(String _nom) {
		return new SalleReunion( _nom );
	}

	public static SalleReunion createSalleReunion(SalleReunion _salle) {
		return new SalleReunion( _salle );
	}
	
	
	// SALLETP
	public static SalleTP createSalleTP() {
		return new SalleTP();
	}

	public static SalleTP createSalleTP(int _nbPostes) {
		return new SalleTP( _nbPostes );
	}

	public static SalleTP createSalleTP(SalleTP _salleTP) {
		return new SalleTP( _salleTP );
	}
	
	// CHARGERECHERCHE
	public static ChargeRecherche createChargeRecherche() {
		return new ChargeRecherche();
	}

	public static ChargeRecherche createChargeRecherche(int _anciennete, String _sujetRecherche) {
		return new ChargeRecherche(_anciennete, _sujetRecherche);
	}

	public static ChargeRecherche createChargeRecherche(ChargeRecherche _chargeRecherche) {
		return new ChargeRecherche(_chargeRecherche);
	}
	
	// MAITREDECONF
	public static MaitreDeConf createMaitreDeConf() {
		return new MaitreDeConf();
	}

	public static MaitreDeConf createMaitreDeConf(int _nbCours, String _sujetConf) {
		return new MaitreDeConf(_nbCours, _sujetConf);
	}

	public static MaitreDeConf createMaitreDeConf(MaitreDeConf _maitreDeConf) {
		return new MaitreDeConf(_maitreDeConf);
	}
	
	// PRAG
	public static PRAG createPRAG() {
		return new PRAG();
	}

	public static PRAG createPRAG(int _echelon) {
		return new PRAG(_echelon);
	}

	public static PRAG createPRAG(PRAG _prag) {
		return new PRAG(_prag);
	}
	
	// PROFESSEUR
	public static Professeur createProfesseur() {
		return new Professeur();
	}

	public static Professeur createProfesseur(ArrayList<String> _matieres, boolean _cherche) {
		return new Professeur(_matieres, _cherche);
	}

	public static Professeur createProfesseur(Professeur _p) {
		return new Professeur(_p);
	}
	
	
}
