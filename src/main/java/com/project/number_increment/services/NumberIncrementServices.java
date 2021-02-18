package com.project.number_increment.services;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import com.project.number_increment.model.NumberIncrement;
import com.project.number_increment.repository.NumberIncrementRepository;

@Service
public class NumberIncrementServices {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	NumberIncrementRepository numberIncrementRepository;

	public synchronized  void increment() {
		try {

			Optional<NumberIncrement> numberData = numberIncrementRepository.findById("1");
			if (numberData.isPresent()) {
				NumberIncrement dbData = numberData.get();
				dbData.setNumber(dbData.getNumber() + 1);
				numberIncrementRepository.save(dbData);

			} else {
				logger.info("Number first time saved");
				NumberIncrement dbData = new NumberIncrement();
				dbData.setId("1");
				dbData.setNumber(dbData.getNumber() + 1);
				numberIncrementRepository.save(dbData);
			}

		}catch (ObjectOptimisticLockingFailureException e) {
			logger.error("concurrency problem");
		}

	}

}
