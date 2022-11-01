package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	List<ProgrammingLanguage> getAll();

	ProgrammingLanguage add(ProgrammingLanguage programmingLanugage);

	ProgrammingLanguage getById(int id);

	void update(ProgrammingLanguage programmingLanugage, int id);

	void delete(int id);
}
