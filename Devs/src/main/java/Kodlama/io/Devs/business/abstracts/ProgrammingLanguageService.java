package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage getById(int id) throws Exception;

	ProgrammingLanguage add(ProgrammingLanguage programmingLanugage) throws Exception;

	void update(ProgrammingLanguage programmingLanugage, int id) throws Exception;

	void delete(int id) throws Exception;

}
