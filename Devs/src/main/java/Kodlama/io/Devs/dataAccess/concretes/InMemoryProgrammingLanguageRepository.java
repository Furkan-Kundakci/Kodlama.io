package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	private List<ProgrammingLanguage> programmingLanugages = new ArrayList<>();

	public InMemoryProgrammingLanguageRepository() {
		programmingLanugages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanugages.add(new ProgrammingLanguage(2, "C"));
		programmingLanugages.add(new ProgrammingLanguage(3, "C++"));
		programmingLanugages.add(new ProgrammingLanguage(4, "C#"));

	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanugages;
	}

	@Override
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanugage) {
		programmingLanugages.add(programmingLanugage);
		return getById(programmingLanugage.getId());
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanugages.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	@Override
	public void update(ProgrammingLanguage programmingLanugage, int id) {
		ProgrammingLanguage programmingLanugageToUpdate = getById(id);
		programmingLanugageToUpdate.setName(programmingLanugage.getName());

	}

	@Override
	public void delete(int id) {
		programmingLanugages.remove(id);
	}

}
