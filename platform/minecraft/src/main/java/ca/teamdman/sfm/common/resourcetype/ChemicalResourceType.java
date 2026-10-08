package ca.teamdman.sfm.common.resourcetype;

import ca.teamdman.sfm.common.blockentity.BufferBlockEntityContents;
import ca.teamdman.sfm.common.capability.SFMBlockCapabilityKind;
import ca.teamdman.sfm.common.registry.SFMRegistryWrapper;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalResource;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.resource.IMekanismResourceHandler;
import mekanism.common.capabilities.Capabilities;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;

import java.util.List;
import java.util.stream.Stream;

public class ChemicalResourceType extends RegistryBackedResourceType<ChemicalStack, Chemical, ResourceHandler<ChemicalResource>> {
    public static final SFMBlockCapabilityKind<ResourceHandler<ChemicalResource>> CAP = new SFMBlockCapabilityKind<>(
            Capabilities.CHEMICAL.block()
    );

    public ChemicalResourceType() {
        super(CAP);
    }

    @Override
    public ResourceHandler<ChemicalResource> createHandlerForBufferBlock(BufferBlockEntityContents contents) {
        IChemicalTank tank = BasicChemicalTank.create(contents.tier.getLongScalarMaxStackSize(), null);
        return (IMekanismResourceHandler<ChemicalResource, IChemicalTank>) () -> List.of(tank);
    }

    @Override
    public long getAmount(ChemicalStack gasStack) {
        return gasStack.amount();
    }

    @Override
    public ChemicalStack getStackInSlot(
            ResourceHandler<ChemicalResource> handler,
            int slot
    ) {
        return handler.getResource(slot).toStack(handler.getAmountAsInt(slot));
    }

    @Override
    public Stream<Identifier> getTagsForStack(ChemicalStack gasStack) {
        return gasStack.tags().map(TagKey::location);
    }

    @Override
    public ChemicalStack extract(
            ResourceHandler<ChemicalResource> handler,
            int slot,
            long amount,
            boolean simulate
    ) {
        ChemicalStack stack = getStackInSlot(handler, slot);
        try (Transaction transaction = Transaction.openRoot()) {
            int extracted = handler.extract(slot, ChemicalResource.of(stack), Math.toIntExact(Math.min(amount, Integer.MAX_VALUE)), transaction);
            if (!simulate) {
                transaction.commit();
            }
            return stack.copyWithAmount(extracted);
        }
    }

    @Override
    public int getSlots(ResourceHandler<ChemicalResource> handler) {
        return handler.size();
    }

    @Override
    public long getMaxStackSize(ChemicalStack gasStack) {
        return Long.MAX_VALUE;
    }

    @Override
    public long getMaxStackSizeForSlot(
            ResourceHandler<ChemicalResource> handler,
            int slot
    ) {
        return handler.getCapacityAsLong(slot, handler.getResource(slot));
    }

    @Override
    public ChemicalStack insert(
            ResourceHandler<ChemicalResource> handler,
            int slot,
            ChemicalStack gasStack,
            boolean simulate
    ) {
        try (Transaction transaction = Transaction.openRoot()) {
            int inserted = handler.insert(slot, ChemicalResource.of(gasStack), gasStack.amount(), transaction);
            if (!simulate) {
                transaction.commit();
            }
            return gasStack.copyWithAmount(gasStack.amount() - inserted);
        }
    }

    @Override
    public boolean isEmpty(ChemicalStack gasStack) {
        return gasStack.isEmpty();
    }

    @Override
    public ChemicalStack getEmptyStack() {
        return ChemicalStack.EMPTY;
    }

    @Override
    public boolean matchesStackType(Object o) {
        return o instanceof ChemicalStack;
    }

    @Override
    public boolean matchesCapabilityHandler(Object o) {
        return o instanceof ResourceHandler<?>;
    }

    @Override
    public SFMRegistryWrapper<Chemical> getRegistry() {
        return new SFMRegistryWrapper<>(MekanismAPI.CHEMICAL_REGISTRY);
    }

    @Override
    public Chemical getItem(ChemicalStack gasStack) {
        return gasStack.getChemical();
    }

    @Override
    public ChemicalStack copy(ChemicalStack gasStack) {
        return gasStack.copy();
    }

    @Override
    protected ChemicalStack setCount(
            ChemicalStack gasStack,
            long amount
    ) {
        gasStack.setAmount(Math.toIntExact(amount));
        return gasStack;
    }
}
