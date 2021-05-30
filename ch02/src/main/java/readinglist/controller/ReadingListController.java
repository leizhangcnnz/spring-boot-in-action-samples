package readinglist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import readinglist.entity.Book;
import readinglist.repository.ReadingListRepository;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    @Autowired
    private ReadingListRepository readingListRepository;

    @RequestMapping(path = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable(value = "reader") String reader, Model model) {

        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(path = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable(value = "reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }

}
