package com.nomii.springbatch.config;

import com.nomii.springbatch.model.Item;
import com.nomii.springbatch.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final ItemRepository itemRepository;

    @Bean
    public FlatFileItemReader<Item> reader(){
        FlatFileItemReader<Item> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new ClassPathResource("files/items.csv"));
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }



    private LineMapper<Item> lineMapper() {
        DefaultLineMapper<Item> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setNames("appliedForRegistration", "vrn", "engineNumber", "chassisNumber", "sumInsured",
                "coiTypeCode", "vehicleColor", "regProvinceCode", "manufactureYear", "keeperName",
                "keeperCNIC", "accessoryName", "accessoryValue", "bodyTypeCode", "passengerCapacity",
                "cubicCapacity", "modelCode", "trackerInstalled", "trackerInstalledType",
                "trackerTypeCode", "serialNumber", "trackerCost", "trackerRegisteredOwner");
        
        BeanWrapperFieldSetMapper<Item> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Item.class);
        
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

}
