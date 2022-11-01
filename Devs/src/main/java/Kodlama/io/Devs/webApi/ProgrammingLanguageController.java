package Kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguageController {

	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return this.programmingLanguageService.getAll();
	}

	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable(name = "id") int id) throws Exception {
		return this.programmingLanguageService.getById(id);
	}

	@PostMapping("/add")
	public String add(@RequestBody ProgrammingLanguage programmingLanugage) throws Exception {
		this.programmingLanguageService.add(programmingLanugage);
		return "Add successful";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable(name = "id") int id) throws Exception {
		this.programmingLanguageService.delete(id);
		return "Delete successful";
	}

	@PutMapping("/{id}")
	public String update(@RequestBody ProgrammingLanguage programmingLanugage, @PathVariable(name = "id") int id) throws Exception {
		this.programmingLanguageService.update(programmingLanugage, id);
		return "Update Successful";
	}

}
