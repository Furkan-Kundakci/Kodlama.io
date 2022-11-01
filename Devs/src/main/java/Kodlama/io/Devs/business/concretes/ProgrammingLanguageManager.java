package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		if (!isIdExist(id)) {
			throw new Exception("ID Not Found");
		}
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanugage) throws Exception {

		if (isIdExist(programmingLanugage.getId())) {
			throw new Exception("This ID already exists");
		}
		if (isNameExist(programmingLanugage.getName())) {
			throw new Exception("This language already exsits");
		}
		return programmingLanguageRepository.add(programmingLanugage);

	}

	@Override
	public void update(ProgrammingLanguage programmingLanugage, int id) throws Exception {
		if (!isIdExist(id)) {
			throw new Exception("There is no such ID");
		}
		if (isNameExist(programmingLanugage.getName())) {
			throw new Exception("This language already exsits");
		}
		programmingLanguageRepository.update(programmingLanugage, id);
	}

	@Override
	public void delete(int id) throws Exception {
		if (!isIdExist(id)) {
			throw new Exception("There is no such ID");
		}
		programmingLanguageRepository.delete(id);

	}

	private boolean isNameExist(String name) {
		for (ProgrammingLanguage programmingLanguage2 : getAll()) {
			if (name.equals(programmingLanguage2.getName())) {
				return true;
			}
		}
		return false;
	}

	private boolean isIdExist(int id) {
		for (ProgrammingLanguage programmingLanguage2 : getAll()) {
			if (programmingLanguage2.getId() == id) {
				return true;
			}
		}
		return false;
	}
}
