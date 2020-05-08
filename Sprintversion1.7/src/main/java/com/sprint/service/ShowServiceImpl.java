package com.sprint.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.MovieDao;
import com.sprint.dao.ShowDao;
import com.sprint.entity.Bookings;
import com.sprint.entity.Movie;
import com.sprint.entity.Show;
import com.sprint.exceptions.ShowNotFound;
import com.sprint.repository.BookingsRepository;
import com.sprint.repository.ShowRepository;

@Service
@Transactional
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowDao showDao;

	@Autowired
	MovieDao movieDao;

	@Override
	public Show addShow(Show show) {
		return showDao.save(show);
	}

	@Override
	public List<Show> getShow() {
		return showDao.getShow();
	}

	@Override
	public String deleteShow(Show show) {
		Optional<Show> s = showDao.findById(show.getShow_Id());
		if (!s.isPresent()) {
			throw new ShowNotFound("Show Not Found!");
		}
		return showDao.deleteShow(show);
	}

	@Override
	public Movie findOne(long Id) {
		return movieDao.findOne(Id);
	}
//	Fetch show by Movie ID

	public List<Show> fetchByMovie(Movie m) {
		return showDao.findBytheMovie(m);
	}

	@Override
	public Show fetchById(long Id) {
		// TODO Auto-generated method stub
		return showDao.getOne(Id);

	}
}