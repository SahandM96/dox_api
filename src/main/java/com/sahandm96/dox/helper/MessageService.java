package com.sahandm96.dox.helper;


import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String code, Object[] args, Locale locale) {
        if (Objects.nonNull(args)) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof String || args[i].getClass().isEnum())
                    args[i] = get(args[i].toString());
                if (args[i] instanceof List) {
                    List lst = (List) args[i];
                    args[i] = lst.stream().map(it -> {
                        if (it instanceof String || it.getClass().isEnum()) {
                            return get(it.toString());
                        } else {
                            return it;
                        }
                    }).collect(Collectors.toList());
                }
                if (args[i] instanceof EnumSet) {
                    EnumSet lst = (EnumSet) args[i];
                    args[i] = lst.stream().map(it -> get(it.toString())).collect(Collectors.toList());
                }
            }
        }
        return messageSource.getMessage(code, args, locale);
    }

    public String get(String code, Object... args) {
        return get(code, args, null);
    }

    public String get(String code) {
        return get(code, null, null);
    }
}
