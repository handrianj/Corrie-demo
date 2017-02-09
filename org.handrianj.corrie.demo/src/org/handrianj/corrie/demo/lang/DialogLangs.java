package org.handrianj.corrie.demo.lang;

import java.util.HashMap;
import java.util.Map;

import org.handrianj.corrie.utilsui.dialog.lang.DialogsLang;

public class DialogLangs extends DialogsLang {

	@Override
	protected Map<String, String> getTextMapForLang(int id) {
		Map<String, String> map = new HashMap<>();

		if (id == 2) {
			map.put(LOG_IN_DIALOG_0, "Connection");
			map.put(LOG_IN_DIALOG_1, "Bienvenue sur ");
			map.put(LOG_IN_DIALOG_2, " veuillez vous identifier");
			map.put(LOG_IN_DIALOG_3, "Connexion");
			map.put(LOG_IN_DIALOG_4, "Mot de passe");
			map.put(LOGIN, "Connecter");
			map.put(LOGOUT_INFO_1, "Deconnection");
			map.put(LOGOUT_INFO_2, "Confirmez");
			map.put(UPDATE_TITLE, "MAJ du mot de passe");
			map.put(PASSWORD_CHANGE, "Changez le mot de passe");
			map.put(PASSWORD_CHANGE_SUCCESS, "MAJ reussie");
			map.put(PASSWORD_ERRO, "Erreur de mise a jour");
			map.put(OLDPASSWORD_ERRO, "Votre ancien password est incorrect");
			map.put(CHANGE_PASSWORD, "MAJ password");
			map.put(INPUTPASSWORDS, "Veuillez entrer votre nouveau password");
			map.put(CURRENT_PASSWORD, "Password actuel");
			map.put(NEW_PASSWORD, "Nouveau password");
			map.put(CONFIRM_PASSWORD, "Confirmation");
			map.put(TOO_SHORT, TOO_SHORT_TEXT_EN);
			map.put(PASSWORD_NOT_MATCH, PASSWORD_NOT_MATCH_TEXT_EN);
			map.put(OK, OK_TEXT_EN);
			map.put(CANCEL, CANCEL_TEXT_EN);
			map.put(SESSION_MENU_2, SESSION_MENU_2_TEXT_EN);
		}

		return map;
	}
}
