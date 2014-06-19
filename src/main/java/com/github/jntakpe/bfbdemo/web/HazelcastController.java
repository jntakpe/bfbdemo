package com.github.jntakpe.bfbdemo.web;

import com.github.jntakpe.bfbdemo.config.CacheConfig;
import com.github.jntakpe.bfbdemo.domain.HazelcastDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Contrôleur de l'écran relatif à Hazelcast
 *
 * @author jntakpe
 */
@Controller
@RequestMapping("/hazelcast")
public class HazelcastController {

    @RequestMapping(method = RequestMethod.GET)
    public String display() {
        return "hazelcast";
    }

    @ResponseBody
    @RequestMapping(value = "/cluster", method = RequestMethod.GET)
    public Set<HazelcastDTO> cluster() {
        return CacheConfig.getHazelcastInstance().getCluster().getMembers().stream().map(
                node -> new HazelcastDTO(
                        node.getSocketAddress().getHostString(),
                        node.getSocketAddress().getPort(),
                        node.localMember())
        ).collect(Collectors.toSet());
    }
}
