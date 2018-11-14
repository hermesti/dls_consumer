package io.sstrategy.demo.dls.consumer;

import org.springframework.stereotype.Component;

import io.sstrategy.demo.dls.library.ConsumerDependentService;

@Component
public class ConsumerDependentServiceImpl implements ConsumerDependentService {

	@Override
	public String truncate(String text) {
		return text.substring(0, 5);
	}

}
