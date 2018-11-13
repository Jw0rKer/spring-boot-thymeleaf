/**
 *
 */
package github.jworker.controller;

import github.jworker.dao.weather.IWeatherRepository;
import github.jworker.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JK
 */
@Controller()
public class ApplicationController {

  @Autowired
  private IWeatherRepository iWeatherRepository;

  @GetMapping("/")
  public String homePage(Model model ) {
    return "main";
  }


  @GetMapping("/current/{id}")
  @ResponseBody
  public Weather findCurrent(@PathVariable  Long id){
    return (Weather) iWeatherRepository.findById(Weather.class,id);
  }

}
